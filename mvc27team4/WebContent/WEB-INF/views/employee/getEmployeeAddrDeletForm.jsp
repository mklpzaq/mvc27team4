<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Address DELETE FORM</title>
<script>
	$(document).ready(function(){
		$("#Allcheck").click(function(){
			if($("#Allcheck").prop("checked")) {
				$("input[type=checkbox]").prop("checked",true);
			}else {
				$("input[type=checkbox]").prop("checked",false);
			}
		})
		function go_delete(){
			if($(":checkbox[id='chk']:checked").length=0)
			 	alert("삭제할 항목을 하나만 체크해주세요.");
		    	return;
		}
	})

</script>
</head>
<body>	
    <br><br>   
    <input type="button" value="삭제" onclick="go_delete();" />
   
    <div class="table-responsive">
      <table class="table table-bordered">
        <thead>
          <tr>
            <th><input type="checkbox" id="Allcheck">선택/Check            
            </th>
            <th>employeeAddrNo</th>
            <th>employeeNo</th>
            <th>address</th>           
          </tr>
        </thead>
        <tbody>
          <tr>
            <th scope="row"><input type="checkbox" name="chk">1</th>
            <td>Table cell</td>
            <td>Table cell</td>
            <td>Table cell</td>
          </tr>
          <tr>
            <th scope="row"><input type="checkbox">2</th>
            <td>Table cell</td>
            <td>Table cell</td>
            <td>Table cell</td>
          </tr>         
        </tbody>        
      </table>
    </div><!-- /.table-responsive -->
  </div>

</body>
</html>