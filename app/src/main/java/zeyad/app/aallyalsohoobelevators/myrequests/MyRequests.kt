package zeyad.app.aallyalsohoobelevators.myrequests

data class MyRequests(
    val Country:String, val Floor :String, val Machine :String,val  Types: String, val imageCabin:String

) {
    constructor() : this(
        "",
        "",
        "",
        "",
        ""
    )

}