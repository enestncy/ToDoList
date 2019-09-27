$(document).ready(function(){
    getLists();
});

function getLists() {

    $.ajax({

        type:"POST",
        url:'getLists',

        success:function (data) {

            var list = "";
            $(data).each(function (i,val) {


                list = list
                    + '<article class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12">'
                    + '<h2 style="margin:5px" class="header"><a href="list/'+val.id+'">'+val.title+'</a></h2>'
                    +'<ul >';

                $(val.items).each(function (i,val) {
                    if(i<2)
                    {
                    list = list
                        + '<li style="color:#999999">'+val.name+'</li>';
                    }
                    else if(i == 2)
                    {
                        list = list
                            + '<li style="color:#999999">...</li>';
                    }
                    else{}
                });

                list = list
                    +'</ul>'
                    + '<span class="fh5co-meta fh5co-date">'+new Date(val.date).toLocaleDateString()+'</span>'
                    + '</article>';

            });

            $('#list').html(list);
        },
        error:function (data) {
            alert("Listeler Yüklenirken Bir Hata Oluştu!");
        }

    });
}