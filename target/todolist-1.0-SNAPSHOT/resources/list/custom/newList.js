function cancel() {window:history.back()}


function newList() {

    var length = document.getElementsByTagName("li").length;

    if(length == 0)
    {

        var param = {

            title : $("#list_name").val()
        };

    }else{

        var list = document.getElementsByTagName("li");
        var items = [length];


        for (i = 0; i < list.length; i++) {

            if(list[i].style.display == "none")
            {
                var item = {
                    name: null,
                    state: null
                }
                items[i] = item;
            }
            else {

                var len = list[i].innerText.length - 2;
                var state = false;
                if (list[i].classList.contains('checked')) {
                    state = true;
                }
                var item = {
                    name: list[i].innerText.substring(0, len),
                    state: state
                };
                items[i] = item;
            }

        }

        var param = {

            title : $("#list_name").val(),
            items : items
        };
    }

    var ser_data = JSON.stringify(param);

    $.ajax({

        type : "POST",
        contentType : 'application/json; charset=UTF-8' ,
        url:'newList',
        data: ser_data,
        success: function(data) {
            if(data == "ERROR_1"){alert("Liste Adı Alanı Boş Bırakılamaz");}
            else if(data == "ERROR_2"){alert("Liste Elemanları Alanı Boş Bırakılamaz");}
            else{window:history.back()}
        },
        error:function(data) {
            alert(data);
        }
    });

}








