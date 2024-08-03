package cd.ketsiatshaba.whatsapp.chat.domain.models

data class Chat(
    val id: Long,
    val receiver: String,
    val messages: String,
    val isRead: Boolean,
    val unReadCount: Int
)
