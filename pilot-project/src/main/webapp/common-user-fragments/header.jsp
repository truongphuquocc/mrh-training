<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="container-fluid">
	<div class="top-banner row">
		<img class="mx-auto" src="images/dmx/Tragop-1200-44-1200x44-1.png" />
	</div>
</div>

<header>
	<div class="container">
		<div class="row">
			<div class="left-area float-left d-flex">
				<div class="logo">
					<a class="logo" title="Về trang chủ DienmayXanh.com" href="/">
						<i class="icon-dmx dmx-logo"></i>
					</a>
				</div>
				<div class="province-box">
					<b>Xem giá, tồn kho ở</b> <a class="province" data-toggle="modal"
						data-target="#selectProvinceModal"> TP. Hồ Chí Minh <i
						class="fas fa-chevron-down"></i></a>
					<div class="modal fade" id="selectProvinceModal" tabindex="-1"
						role="dialog" aria-labelledby="myLargeModalLabel"
						aria-hidden="true">
						<div class="modal-dialog modal-md">
							<div class="modal-content">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close"></button>
								<div class="modal-body">
									<form>
										<div class="form-group">
											<label for="province"><strong>Chọn Tỉnh
													Thành</strong></label> <select class="form-control" id="province">
												<option>TP. Hồ Chí Minh</option>
												<option>TP. Hà Nội</option>
												<option>TP. Huê</option>
											</select>
										</div>
										<div class="form-group">
											<label for="district"><strong>Chọn đầy đủ
													địa chỉ nhận hàng</strong> để biết chính xác thời gian giao</label> <select
												class="form-control" id="district">
												<option>Vui lòng chọn Quận/Huyện</option>
											</select>
										</div>
										<div class="form-group">
											<select class="form-control" id="province" disabled>
												<option>Vui lòng chọn Phường/Xã</option>
											</select>
										</div>
										<div class="form-group">
											<input type="text" class="form-control" id="detailAddress"
												placeholder="Số nhà, tên đường" disabled>
										</div>
									</form>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default accept-btn"
										data-dismiss="modal">Xác Nhận</button>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="search-area">
					<form class="search-form">
						<div class="input-group">
							<input type="text" class="form-control"
								placeholder="Bạn tìm gì...">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-search"></i></span>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="right-area float-right">
				<a href="/kinh-nghiem-hay" class="refer-link">Kinh nghiệm hay <span>&amp;
						Tin khuyến mãi <label class="arr-down"></label>
				</span></a> <a href="/kinh-nghiem-hay" class="refer-link">1800.1061 <span>&amp;
						Tổng đài miễn phí </span></a> <a href="/kinh-nghiem-hay"
					class="refer-link one-line"><i class="fas fa-shopping-cart"></i></a>
				<a href="/kinh-nghiem-hay" class="refer-link one-line">Lịch sử
					mua hàng</a>
			</div>
		</div>
	</div>
</header>