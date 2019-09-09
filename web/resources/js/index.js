function loginErrorHandler(){
    $.post("${pageContext.request.contextPath}/login/loginVerification", function(data){
        if(data != null){
            $('#errormessage').text(data);
            $('#errormessage').classList.remove("hide");
        } else {
            window.location.href("${pageContext.request.contextPath}/dashboard");
        }
    })
}