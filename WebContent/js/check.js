function check() {
  if (checkName() && checkPwd()) {
    return true;
  }
  return false;
}
function checkName() {
  var name = document.getElementById("username").value;
  if (name.length == 0) {
    alert("用户名不能为空");
    return false;
  }
  return true;
}
function checkPwd() {
  var password = document.getElementById("userPassword").value;
  var passwordRepeat = document.getElementById("userPasswordRepeat").value;
  if (password.length == 0) {
    alert("密码不能为空");
    return false;
  }
  if (passwordRepeat.length == 0) {
    alert("确认密码不能为空");
    return false;
  }
  if (password != passwordRepeat) {
    alert("两次密码输入不一致");
    return false;
  }
  return true;
}
function checkExistName() {

  var name = $("#username").val();
  $.ajax({
    type:"post",
    url:"CheckNameServlet",
    data:"username="+name,
    success:function (msg) {
      $("#usernameMsg").html(msg);
      if(msg=="该账户已存在") {
    	  $("#username").val("");
      }
    }
  })

}