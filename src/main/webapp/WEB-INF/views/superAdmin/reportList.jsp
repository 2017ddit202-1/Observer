<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<body>
	     <table class="table table-striped table-bordered">
  <thead>
    <tr>
      <th>Admin ID</th>
      <th>비고</th>
    </tr>
  </thead>

  <tbody>
    <!-- iteração -->
    <tr>
      <td>R$ 831,00</td>
      <td><button data-pedido="1321" data-toggle="modal" data-target="#myModal"  class="btn btn-primary"><i class="glyphicon glyphicon-plus"></i></button></td>
    </tr>
    <!-- fim iteração-->
  </tbody>
</table>

<div id="myModal" class="modal fade in">
        <div class="modal-dialog">
            <div class="modal-content">
 
                <div class="modal-header">
                    <a class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span></a>
                    <h4 class="modal-title">Modal Heading</h4>
                </div>
                <div class="modal-body">
                    <h4>Text in a modal</h4>
                    <p>Duis mollis, est non commodo luctus, nisi erat porttitor ligula.</p>
                </div>
                <div class="modal-footer">
                    <div class="btn-group">
                        <button class="btn btn-danger" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
                        <button class="btn btn-primary"><span class="glyphicon glyphicon-check"></span> Save</button>
                    </div>
                </div>
 
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dalog -->
    </div><!-- /.modal -->
</body>
