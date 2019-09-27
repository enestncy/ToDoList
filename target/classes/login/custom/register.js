function register() {

    var param = {

        name : $("#name").val(),
        surname : $("#surname").val(),
        username : $("#username").val(),
        email : $("#email").val(),
        pass : $("#pass").val(),
        pass2 : $("#pass2").val()
    }

    var ser_data = JSON.stringify(param);

    $.ajax({

        type : "POST",
        contentType : 'application/json; charset=UTF-8',
        url :'addUser',
        data : ser_data,
        success : function (data) {
            if(data =='ERR_USERNAME'){
                alert("Bu Kullanıcı Adı Daha Önceden Alınmış!")
            }
            else if(data =='ERR_MAIL'){
                alert("Lütfen Geçerli Bir Mail Adersi Giriniz!")
            }
            else if(data == 'ERR_PASS'){
                alert("Parolalar Eşleşmiyor!")
            }else if(data == 'OK')
            {
                alert("Üye Olma İşlemi Başarılı!")
            }
            else if(data == 'ERROR')
            {
                alert("Hata , Tekrar Deneyiniz!")
            }
        },
        error : function (data) {
            
        }

    });

}