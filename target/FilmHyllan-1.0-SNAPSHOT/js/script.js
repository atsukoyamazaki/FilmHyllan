$(document).ready(function() {


    $("#loginButton").on("click", function() {
        //reviewlist(1);
        login();
    });

    var listURL = "http://localhost:8080/FilmHyllan/webresources/entity.user/login";

    function login() {

        console.log(listURL);
        var htmlpart = "";
        alert(formToJSON());
        $.ajax({
            type: "PUT",
            url: listURL,
            contentType: "application/json",
            data: formToJSON(),
            dataType: 'json',
            success: function(data) {
                alert("loginCheck");
                htmlpart = "<div id='postList'>";
                var filmID = 0;
                var directorPart = "";
                for (var no in data)
                {
                    if (data[no][0].film.filmID != filmID) {
                        filmID = data[no][0].film.filmID;
                        htmlpart = htmlpart + "<div id='img'><img src='http://images.amazon.com/images/P/" + data[no][0].film.img + ".09._PC_OU09_SCMZZZZZZZ_.jpg'>" + data[no][0].film.title + " " + directorPart + "," + data[no][1].directorName;
                        htmlpart = htmlpart + "</div><div id='title'>" + data[no][0].rating + "</div>";
                    }
                    else {
                        directorPart = directorPart + data[no][1].directorName + ", ";
                    }


                    console.log(data[no]);
                }
                htmlpart = htmlpart + "</div>";
                $('#postList').append(htmlpart);
                $('#loginForm').hide();
                console.log(htmlpart);
            },
            complete: function(data) {
                alert(data.responseText)
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(textStatus);
                alert(errorThrown);
            }

        });
        function formToJSON() {
            return JSON.stringify({
                "userName": $('#userName').val(),
                "password": $('#password').val()
            });
        }

    }
    function reviewlist(id) {

        console.log(listURL + id);
        var htmlpart = "";
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/FilmHyllan/webresources/entity.review/reviewlist/" + id,
            dataType: "json", // data type of response
//            jsonp: "callback",
//            jsonpCallback: 'jsonCallback',
//            contentType: "application/json",
            success: function(data) {
                alert("loginCheck");
                htmlpart = "<div id='postList'>";
                for (var no in data)
                {
                    htmlpart = htmlpart + "<div id='img'><img src='http://images.amazon.com/images/P/" + data[no].film.img + ".09._PC_OU09_SCMZZZZZZZ_.jpg'>" + data[no].film.title + " " + data[no].film.director + "</div>";
                    htmlpart = htmlpart + "<div id='title'>" + data[no].film.title + "</div>";
                }
                htmlpart = htmlpart + "</div>";
                $('#postList').append(htmlpart);
                console.log(htmlpart);
                alert("test");
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(textStatus);
                alert(errorThrown);
            }
        });

    }

    function jsonCallback(json) {
        alert("callback");
    }
});