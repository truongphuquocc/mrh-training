<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="container mt-3">
	<div class="main-content">
		<section>
			<h2>Product</h2>
		</section>
		<div class="box box-success">
			<div class="box-body">
				<div class="form-row">
					<div class="form-group col-3">
						<div class="input-group">
							<div class="input-group-append">
								<label for="" class="input-group-text">Price from</label>
							</div>
							<select class="custom-select mr-sm-2" id="priceFrom">
								<option value="0" selected>Choose Price...</option>
								<option value="5000000">5.000.000</option>
								<option value="10000000">10.000.000</option>
								<option value="20000000">20.000.000</option>
								<option value="25000000">25.000.000</option>
							</select>
						</div>
					</div>
					<div class="form-group col-3">
						<div class="input-group">
							<div class="input-group-append">
								<label for="" class="input-group-text">Price from</label>
							</div>
							<select class="custom-select mr-sm-2" id="priceTo">
								<option value="0" selected>Choose Price...</option>
								<option value="10000000">10.000.000</option>
								<option value="15000000">15.000.000</option>
								<option value="20000000">20.000.000</option>
								<option value="25000000">25.000.000</option>
								<option value="30000000">30.000.000</option>
							</select>
						</div>
					</div>
					<div class="input-group d-flex col-6">
						<input type="text" class="form-control" id="keyword"
							placeholder="Something clever..">
						<div class="d-block">
							<button class="btn btn-primary" id="searchProductBtn"
								type="button">
								<i class="fa-solid fa-magnifying-glass"></i>
							</button>
							<button class="btn btn-success" id="addProductInfoModal"
								type="button">
								<i class="fa-solid fa-plus"></i> Add Product
							</button>
							<button class="btn btn-secondary" id="clearSearchFieldBtn">
								<i class="fas fa-times"></i>&nbsp;Clear
							</button>
						</div>

					</div>
				</div>
				<table class="table table-bordered" id="productInfoTable">
					<thead>
						<tr class="text-center">
							<th scope="col">#</th>
							<th scope="col">Product Name</th>
							<th scope="col">Quantity</th>
							<th scope="col">Price</th>
							<th scope="col">Brand Name</th>
							<th scope="col">opening For Sale</th>
							<th scope="col">Image</th>
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
<!-- Modal Add and Edit Product -->
<div class="modal fade bd-example-modal-lg" id="productInfoModal">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<form id="productInfoForm" role="form" enctype="multipart/form-data">
				<div class="modal-header">
					<h5 class="modal-title">Add Product</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="form-group row d-none" id="formProductId">
						<label for="productId" class="col-sm-3 col-form-label">Product
							ID</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="productId" readonly
								name="productId" placeholder="Product ID">
						</div>
					</div>
					<div class="form-group row">
						<label for="inputPassword" class="col-sm-3 col-form-label">Product
							Name<span class="required-mask ml-1">(*)</span>
						</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="productName"
								name="productName" placeholder="Product Name">
						</div>
					</div>
					<div class="form-group row">
						<label for="quantity" class="col-sm-3 col-form-label">Quantity<span
							class="required-mask ml-1">(*)</span></label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="quantity"
								id="quantity" placeholder="Quantity">
						</div>
					</div>
					<div class="form-group row">
						<label for="price" class="col-sm-3 col-form-label">Price<span
							class="required-mask ml-1">(*)</span></label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="price" id="price"
								placeholder="Price">
						</div>
					</div>
					<div class="form-group row">
						<label for="brandName" class="col-sm-3 col-form-label">Brand
							Name<span class="required-mask ml-1">(*)</span>
						</label>
						<div class="col-sm-9">
							<select class="custom-select mr-sm-2" name="brand" id="brand">
								<option value="">Choose Brand Name...</option>
							</select>
						</div>
					</div>
					<div class="form-group row">
						<label for="openingForSale" class="col-sm-3 col-form-label">Opening
							For Sale<span class="required-mask ml-1">(*)</span>
						</label>
						<div class="col-sm-9">
							<div class="datepicker date input-group">
								<input type="text" placeholder="Opening For Sale" name="saleDate"
									class="form-control" id="saleDate">
								<div class="input-group-append">
									<span class="input-group-text"><i class="fa fa-calendar"></i></span>
								</div>
							</div>
						</div>
					</div>
					<div class="form-group row">
						<label for="inputPassword" class="col-sm-3 col-form-label">Description</label>
						<div class="col-sm-9">
							<textarea name="description" id="description" cols="30" rows="2"
								class="form-control" placeholder="Description"></textarea>
						</div>
					</div>
					<div class="form-group row d-flex align-items-center"
						id="productLogo">
						<label class="col-sm-3 col-form-label" for="logo">Logo <span
							class="required-mask">(*)</span></label>
						<div class="col-sm-9">
							<div class="file-upload">
								<div class="image-upload-wrap">
									<input class="file-upload-input upload-image" id="customFile"
										name="imageFiles" type='file' onchange="readURL(this);"
										accept="image/*" /> <input type="hidden" class="old-img"
										id="image" name="image">
									<div class="drag-text">
										<h3>Drag and drop a file or select add Image</h3>
									</div>
								</div>
								<div class="file-upload-content">
									<div id="logoImg">
										<img class="img-thumbnail file-upload-image" src="#"
											alt="your image" />
									</div>
									<div class="image-title-wrap ml-3">
										<button type="button" onclick="removeUpload()"
											class="btn btn-danger">Remove</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Cancel</button>
					<button type="button" class="btn btn-primary" id="saveProductBtn">Save</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!-- Modal Confirm Deleting Product -->
<div class="modal fade" id="confirmDeleteModal">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Delete Product</h5>
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
				<button type="button" class="btn btn-danger" id="deleteSubmitBtn">Delete</button>
			</div>
		</div>
	</div>
</div>