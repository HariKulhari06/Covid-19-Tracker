package com.hari.covid_19app.firebaseDatabase

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.hari.covid_19app.model.LoadState
import com.hari.covid_19app.model.Prevention
import com.hari.covid_19app.model.Question
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirebaseDatabaseImp @Inject constructor() : FirebaseDatabase {

    override fun getPopularQuestions() = callbackFlow<LoadState<List<Question>>> {
        offer(LoadState.Loading)
        Firebase.database.getReference(ENDPOINT_FAQ).addValueEventListener(object :
            ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                LoadState.Error<List<Question>>(Throwable(error.message))
                close(Throwable(error.message))
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.value == null) {
                    offer(LoadState.Loaded(emptyList()))
                } else {
                    val value = snapshot.value as ArrayList<HashMap<String, String>>
                    val filter = value.filter {
                        it != null
                    }

                    val map = filter.map {
                        Question(
                            answer = it[ANSWER],
                            question = it[QUESTION]
                        )
                    }
                    offer(LoadState.Loaded(map))
                }

            }

        })

        awaitClose { cancel() }
    }

    override fun getPreventions() = callbackFlow<LoadState<List<Prevention>>> {
        offer(LoadState.Loading)
        Firebase.database.getReference(ENDPOINT_PREVENTIONS).addValueEventListener(object :
            ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                LoadState.Error<List<Question>>(Throwable(error.message))
                close(Throwable(error.message))
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.value == null) {
                    offer(LoadState.Loaded(emptyList()))
                } else {
                    val value = snapshot.value as ArrayList<HashMap<String, String>>
                    val filter = value.filter {
                        it != null
                    }

                    val map = filter.map {
                        Prevention(
                            title = it[TITLE],
                            description = it[DESCRIPTION],
                            imageUrl = it[IMAGE_URL]
                        )
                    }
                    offer(LoadState.Loaded(map))
                }

            }

        })

        awaitClose { cancel() }
    }

    companion object {
        const val ENDPOINT_FAQ = "faq"
        const val ENDPOINT_PREVENTIONS = "preventions"

        const val ID = "id"
        const val ANSWER = "answer"
        const val QUESTION = "question"

        const val TITLE = "title"
        const val DESCRIPTION = "description"
        const val IMAGE_URL = "image_url"
    }

}