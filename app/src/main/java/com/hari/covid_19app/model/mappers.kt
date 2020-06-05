package com.hari.covid_19app.model

fun <F, T> Mapper<F, T>.forLists(): suspend (List<F>) -> List<T> {
    return { list -> list.map { item -> map(item) } }
}

fun <F, T> IndexedMapper<F, T>.forLists(): suspend (List<F>) -> List<T> {
    return { list -> list.mapIndexed { index, item -> map(index, item) } }
}

fun <F, T1, T2> pairMapperOf(
    firstMapper: Mapper<F, T1>,
    secondMapper: Mapper<F, T2>
): suspend (List<F>) -> List<Pair<T1, T2>> {
    return { from ->
        from.map { firstMapper.map(it) to secondMapper.map(it) }
    }
}

fun <F, T1, T2> pairMapperOf(
    firstMapper: Mapper<F, T1>,
    secondMapper: IndexedMapper<F, T2>
): suspend (List<F>) -> List<Pair<T1, T2>> {
    return { from ->
        from.mapIndexed { index, value ->
            firstMapper.map(value) to secondMapper.map(index, value)
        }
    }
}

fun <F, T> Mapper<F, T>.toLambda(): suspend (F) -> T {
    return { map(it) }
}
