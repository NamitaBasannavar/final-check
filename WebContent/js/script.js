
function validation() {
                var a = document.forms["form"]["txttitle"].value;
                if(a== "") {
                                alert("Title is Required");
                                return false;
                           }
                if ((a.length < 2) || (a.length > 65)) {
                                alert("Title should have 2 to 65 characters.");
                                return false;
                            }
                var b = document.forms["form"]["txtGross"].value;
                if(b== "") {
                                alert("Gross is required.");
                                return false;
                           }
                if(/[^0-9/]/.test(b)) {
                                alert("Gross has to be a number.");
                                return false;
                           }
                var c = document.forms["form"]["txtDoL"].value;
                if(c== "") {
                                alert("Date of launch is required.");
                                return false;
                           }
                var d = document.forms["form"]["Genre"].value;
                if(d== "") {
                                alert("Genre is required.");
                                return false;
                           }
}
