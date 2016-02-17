function makeUserNameMsg(name){
   var len = name.length;
   
   if (len == 0) {
     return "이름을 입력해주세요.";
   } 
   if(len < 2){
     return "이름은 2자 이상이어야 합니다.";
   }
   
   return "";
};

function makeEmailValidation(email){
  var reg_email = /^[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[@]{0}[-A-Za-z0-9_.]*$/;

  if (email.length == 0) {
    return "이메일을 입력해주세요.";
  } 
  if (email.search(reg_email) == -1) {
    return "이메일 포멧이 올바르지 않습니다.";
  }
  
  return "";
}

function showWarningColor(idString, validationMsg){
  
  if(validationMsg !== ""){
    $(idString).css("border", "1px solid #ff0000");
    return;
  }
  $(idString).css("border", "1px solid #000000");
}

$(document).ready(function() {

  $("#success_msg").hide();
  $("#name_error").hide();
  $("#email_error").hide();
  
  $("#name").on("input", function() {
    var username = $(this).val(); 
    var validationMsg = makeUserNameMsg(username);
    
    if(validationMsg !== ""){
      $("#name_error").show();
      $("#name_error").html(validationMsg);
    }
    else{
      $("#name_error").hide();
    }
    showWarningColor("#name", validationMsg);
  });

  $("#email").on("input", function() {
    var email = $(this).val();
    var validationMsg = makeEmailValidation(email);
    
    if(validationMsg !== ""){
      $("#email_error").show();
      $("#email_error").html(validationMsg);
    }
    else{
      $("#email_error").hide();
    }
    
    showWarningColor("#email", validationMsg);
  });
  
  $("#recipient_info").submit(function() {
    var name=$("#name").val();
    var email=$("#email").val();
    
    if(makeUserNameMsg(name) !== "" || makeEmailValidation(email) !== ""){
      return false;
    }
    
    var url = "/email/store.do?name=" + name + "&email=" + email;
    $.get(url, function(msg){
      msg = msg.trim();
      var success_msg=$("#success_msg");

      success_msg.show();
      if(msg === (name + "님의 정보를 성공적으로 저장했습니다.")){
        success_msg.attr("class", "alert alert-success");
        success_msg.html(msg);
      }
      else{
        success_msg.attr("class", "alert alert-danger");
        success_msg.html(msg);
      }
    });
    return false;
  });
});
