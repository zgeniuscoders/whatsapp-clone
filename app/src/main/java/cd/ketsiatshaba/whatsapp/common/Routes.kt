package cd.ketsiatshaba.whatsapp.common

sealed class Routes(val route: String) {
    data object splash_page : Routes("splash_view")
    data object home_page : Routes("home_view")
    data object actus_page : Routes("actus_view")
    data object call_page : Routes("call_view")
    data object community_page : Routes("community_view")
    data object start_chat_page : Routes("start_chat_view")
    data object settings_page : Routes("settings_view")
}