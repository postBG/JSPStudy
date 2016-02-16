$(document).ready(function(){
  $("#search").submit(function(){
    var searchWord = $("#search_word").val();
    var url = "/email/search.do?search_word=" + searchWord;
    
    $.get(url, function(responseText){
      $("#search_result").html(responseText);
    });
    return false;
  });
});
