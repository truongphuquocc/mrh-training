<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="mt-3">
	<div class="main-content">
		<section>
			<h2>Brand</h2>
		</section>
		<div class="box box-success">
			<div class="box-body">
				<div class="input-group mb-1">
					<input type="text" class="form-control fieldset" id="keyword"
						placeholder="Brand Name, Description"> <i
						class="fa-solid fa-xmark clear-icon" id="clearSearchFieldBtn"></i>
					<div class="input-group-append">
						<button class="btn btn-primary" id="searchBrandBtn" type="button">
							<i class="fa-solid fa-magnifying-glass"></i>
						</button>

					</div>
					<div class="input-group mt-1 justify-content-end">
						<button class="btn btn-success" id="addBrandInfoModal"
							type="button">
							<i class="fa-solid fa-plus"></i> Add brand
						</button>
					</div>
				</div>

				<table class="table table-bordered" id="brandInfoTable">
					<thead>
						<tr class="text-center">
							<th scope="col">#</th>
							<th scope="col">Name</th>
							<th scope="col">Logo</th>
							<th scope="col">Description</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
				<nav aria-label="Page navigation example">
					<ul class="pagination justify-content-end">
					</ul>
				</nav>
			</div>
		</div>
	</div>
</div>
<!-- Modal Add and Edit Brand -->
<div class="modal fade" id="brandInfoModal">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<form id="brandInfoForm" role="form" enctype="multipart/form-data">
				<div class="modal-header">
					<h5 class="modal-title">Add Brand</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="form-group d-none">
						<label>Brand ID</label> <input type="text" class="form-control"
							name="brandId" id="brandId" placeholder="Brand ID" readonly>
					</div>
					<div class="form-group">
						<label for="brandName">Brand Name <span
							class="required-mask">(*)</span></label> <input type="text"
							class="form-control" id="brandName" name="brandName"
							placeholder="Brand Name">
					</div>
					<div class="form-group" id="brandLogo">
						<label for="logo">Logo <span class="required-mask">(*)</span></label>
						<div class="preview-image-upload" id="logoImg">
							<img src="<c:url value='/images/common/image-demo.png'/>"
								alt="image">
						</div>
						<input type="file" class="form-control upload-image"
							name="logoFiles" accept="image/*" /> <input type="hidden"
							class="old-img" id="logo" name="logo">
					</div>
					<div class="form-group">
						<label for="description">Description</label>
						<textarea name="description" id="description" cols="30" rows="3"
							class="form-control" placeholder="Description"></textarea>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Cancel</button>
					<button type="button" class="btn btn-primary" id="saveBrandBtn">Save</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!-- Modal Confirm Deleting Brand -->
<div class="modal fade" id="confirmDeleteModal">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Delete Brand</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p>
					Do you want to delete <b id="deletedBrandName"></b>?
				</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
				<button type="button" class="btn btn-primary" id="deleteSubmitBtn">Save</button>
			</div>
		</div>
	</div>
</div>