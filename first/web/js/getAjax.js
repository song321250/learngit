/**
 * Created by song on 2017/6/7.
 */
function getXMLhttp() {
    var xmlhtttp;
    if (window.XMLHttpRequest){
        xmlhtttp = new XMLHttpRequest();
    }else{
        xmlhtttp = new ActiveXObject();
    }
    return xmlhtttp;

}

function useAjax(data) {
    var url ="ser?op=ajax";
    var xml = getXMLhttp()
    var value =data.value

    xml.onreadystatechange = function () {
        if (xml.readyState==4){
            if(xml.status==200){
               document.getElementById("myspan").innerHTML = xml.responseText;
            }

        }
    }
    xml.open('post',url,true);
    xml.setRequestHeader("Content-type","application/x-www-form-urlencoded")
    var da ="fpvalue="+value;
    xml.send(da);
}

