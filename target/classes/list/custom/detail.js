$(document).ready(function() {
    getList();
});


function getList() {

    //$("#addButton").attr("onclick",false);

    $("#list_title").attr("disabled", true);
    $("#myInput").attr("disabled", true);
    $("#updateBtn").html("GÜNCELLE");

    $.ajax({

        type:"POST",
        url : './../getList',
        contentType : 'text/plain',
        data : $("#id").val() + "",

        success : function(data) {

            $("#list_title").val(data.title);
            var list="";
            $(data.items).each(function (i,val) {

                if(val.state == 0) {
                    list = list
                        + '<li>'+val.name+' <SPAN class="close_item" >\u00D7</SPAN></li>';


                }
                else{
                    list = list
                        + '<li class="checked">'+val.name+' <SPAN class="close_item">\u00D7</SPAN></li>';

                }
            });

            $('#myUL').html(list);

        },
        error : function(data) {
            alert(data);
        }
    });
}





var flag = false;

function update() {

    if (!flag) {

        var cls = document.getElementsByClassName("close_item");
        var i;
        for (i = 0; i < cls.length; i++) {
            cls[i].onclick = function() {
                var div = this.parentElement;
                div.style.display = "none";
            }
        }

        $("#list_title").attr("disabled", false);
        $("#myInput").attr("disabled", false);
        //$("#addButton").attr("onclick",true);

        $("#updateBtn").html("KAYDET");
        flag = true;
    } else {
        updateList();
        flag = false;

    }
}




function updateList() {

    var length = document.getElementsByTagName("li").length;

    if(length == 0)
    {

        var param = {

            title : $("#list_title").val(),
            id : $("#id").val()
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
            else{
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

                title: $("#list_title").val(),
                items: items,
                id: $("#id").val()
            };

    }

    var ser_data = JSON.stringify(param);

    $.ajax({

        type : "POST",
        contentType : 'application/json; charset=UTF-8' ,
        url:'./../updateList',
        data: ser_data,
        success: function(data) {
            if(data == "ERROR_1") {alert("Liste Adı Alanı Boş Bırakılamaz");}
            else if(data == "ERROR_2"){alert("Liste Elemanları Alanı Boş Bırakılamaz");}
            else{
                window:history.back();
            }
        },
        error:function(data) {
            alert(data);
        }
    });

}


function deleteList() {

    var param = {

        id : $("#id").val()

    }

    var ser_data = JSON.stringify(param);

    $.ajax({

        type : "POST",
        contentType : 'application/json; charset=UTF-8',
        url : './../deleteList',
        data : ser_data,
        success : function(data) {
            alert("Listeniz Başarı ile Silindi");
            window.history.back();
        },
        error : function(data) {
            alert(data);
        }
    });

}
