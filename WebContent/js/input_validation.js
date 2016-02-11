$(document).ready(function() {

  $("#username").on("input", function() {
    var len = $(this).val().length;

    if (len == 0) {
      $("#username_error").html("이름을 입력해주세요.");
    } else if (len < 2) {
      $("#username_error").html("이름은 2자 이상이어야 합니다.");
    } else {
      $("#username_error").html("");
    }
  });

  $("#email").on("input", function() {
    var email = $(this).val();
    var reg_email = /^[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[@]{0}[-A-Za-z0-9_.]*$/;

    if (email.length == 0) {
      $("#password_error").html("이메일을 입력해주세요.");
    } else if (email.search(reg_email) == -1) {
      $("#password_error").html("이메일 포멧이 올바르지 않습니다.");
    } else {
      $("#password_error").html("");
    }
  });

  $("#user_info").submit(function() {
    var url = "/email/store?username=" + $("#username").val() + "&email=" + $("#email").val();  
    $.get(url, function(userName){
      $("#success_msg").html(userName + "님의 정보를 성공적으로 저장했습니다.");
    });
    return false;
  });
});
