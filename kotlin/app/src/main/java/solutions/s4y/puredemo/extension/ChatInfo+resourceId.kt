package solutions.s4y.puredemo.extension

import solutions.s4y.puredemo.ca.domain.models.ChatInfo
import solutions.s4y.puredemo.R

val ChatInfo.resourceId: Int
    get() = when (imageUrl) {
        "https://example.com/image1.jpg" -> R.drawable.user1
        "https://example.com/image2.jpg" -> R.drawable.user2
        "https://example.com/image3.jpg" -> R.drawable.user3
        "https://example.com/image4.jpg" -> R.drawable.user4
        "https://example.com/image5.jpg" -> R.drawable.user5
        "https://example.com/image6.jpg" -> R.drawable.user6
        else -> R.drawable.user1
    }