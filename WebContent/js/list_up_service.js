$(document).ready(function(){
  $("#search").submit(function(){
    var searchWord = $("#search_word").val();
    
    if(!searchWord){
      $("#search_result").hide();
      $("#default_list").show();
      return false;
    }
    var url = "/email/search.do?search_word=" + searchWord;
    
    $.get(url, function(responseText){
      $("#search_result").html(responseText);
      $("#search_result").show();
      $("#default_list").hide();
    });
    return false;
  });
});
