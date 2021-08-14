
function onSearchbarChanged() {
    var searchBar = document.getElementById("searchBar")
    var value = encodeURI(searchBar.value)
    var query = "/search?q="+value
    console.log(query)
}
