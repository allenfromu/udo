/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function create_user(){
    var first_name = $('[name="first_name"]').val();
    var last_name = $('[name="last_name"]').val();
    var display_name = $('[name="display_name"]').val();
    var phone = $('[name="phone"]').val();
    var email = $('[name="email"]').val();
    var pw = $('[name="password"]').val();
    var street = $('[name="street"]').val();
    var city = $('[name="city"]').val();
    var state = $('[name="state"]').val();
    var country = $('[name="country"]').val();
    var zip_code = $('[name="zipcode"]').val();
    if(first_name.length < 1){
        alert("Input first name please");
    }else if(last_name.length < 1){
        alert("Input last name please");
    }else if(display_name.length < 1){
        alert("Input display name please");
    }else if(phone.length < 1){
        alert("Input phone please");
    }else if(email.length < 1){
        alert("Input email please");
    }else if(pw.length < 1){
        alert("Input password please");
    }else if(street.length < 1){
        alert("Input street name please");
    }else if(city.length < 1){
        alert("Input city please");
    }else if(country.length < 1){
        alert("Input country name please");
    }else if(zip_code.length < 1){
        alert("Input zip code please");
    }else {
        console.log("password:"+pw);
        var jso = {first_name:first_name,
            last_name:last_name,
            display_name:display_name,
            phone:phone,
            email:email,
            password:pw,
            street:street,
            city:city,
            state:state,
            country:country,
            zip_code:zip_code
        }
        var url="rest/postuser/add";
        console.log(jso);
        $.ajax({
                    type: "POST",
                    dataType:"json",
                    contentType: "application/json",
                    data:JSON.stringify(jso),
                    url:  url,
                    success: function(data) {
                        console.log("response:" + data);
                    },
                    error: function(jqXHR, textStatus, errorThrown) {
                        console.log(' Error in processing! '+textStatus);
                    }
        });
    }
    
    
    
}
