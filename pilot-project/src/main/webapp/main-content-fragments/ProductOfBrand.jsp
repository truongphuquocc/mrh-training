<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<section class="row discount-in-day">
	<div class="section-title">Điện Thoại</div>
	<div class="group-tabs">
		<div class="box-filter mb-3 ">
			<div class="dropdown">
				<button class="btn" type="button" id="dropdownMenuButton1"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<i class="fa-solid fa-filter" style="color: #050505;"></i> Bộ lọc
				</button>
				<div class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
					<div class="mb-3">
						<b>Hãng</b>
					</div>
					<div class="grid-dropdown-item brandInfo"></div>
					<div class="dropdown-divider"></div>
					<div class="filter-all">
						<div>
							<div class="mb-3">
								<b>Loại điện thoại</b>
							</div>
							<div class="d-flex">
								<a class="dropdown-item btn-dropdown" href="#">Adroid</a> <a
									class="dropdown-item btn-dropdown" href="#">Iphone(IOS)</a>
							</div>
						</div>
						<div>
							<div class="mb-3">
								<b>Giá</b>
							</div>
							<div class="grid-dropdown-item">
								<a class="dropdown-item btn-dropdown" href="#">Dưới 2 triệu</a>
								<a class="dropdown-item btn-dropdown " href="#">Từ 2 - 4
									triệu</a> <a class="dropdown-item btn-dropdown" href="#">Từ 4 -
									7 triệu</a> <a class="dropdown-item btn-dropdown" href="#">Từ 7
									- 13 triệu</a> <a class="dropdown-item btn-dropdown" href="#">Từ
									13 - 20 triệu</a> <a class="dropdown-item btn-dropdown" href="#">Trên
									20 triệu</a>
							</div>
							<form class="range-price">
								<div class="display m-0 mt-3">
									<span class=" text-center btn-dropdown" id="min">300000</span>
									<span class=" text-center btn-dropdown" id="max">42000000</span>
								</div>
							</form>
							<div class="range-slide">
								<div class="slide">
									<div class="line" id="line" style="left: 0%; right: 0%;"></div>
									<span class="thumb" id="thumbMin" style="left: 0%;"></span> <span
										class="thumb" id="thumbMax" style="left: 100%;"></span>
								</div>
								<input id="rangeMin" type="range" max="42000000" min="300000"
									step="100000" value="0"> <input id="rangeMax"
									type="range" max="42000000" min="300000" step="100000"
									value="42000000">
							</div>
						</div>
					</div>
					<div
						class="filter-button filter-button--total d-flex mb-3 justify-content-center pt-3"
						style="display: block;">
						<a class="btn btn-primary" href="javascript:void(0)"
							class="btn-filter-close">Bỏ chọn</a> <a class="btn btn-danger"
							href="javascript:;" class="btn-filter-readmore">Xem <b
							class="total-reloading">6</b> kết quả
						</a>
					</div>
				</div>
			</div>
			<div class="dropdown">
				<button class="btn dropdown-toggle" type="button"
					id="dropdownMenuButton2" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false">Hãng</button>
				<div class="dropdown-menu" aria-labelledby="dropdownMenuButton2">
					<div class="grid-dropdown-item brandInfo"></div>
				</div>
			</div>
			<div class="dropdown">
				<button class="btn dropdown-toggle" type="button"
					id="dropdownMenuButton3" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false">Giá</button>
				<div class="dropdown-menu" aria-labelledby="dropdownMenuButton3">
					<div class="grid-dropdown-item">
						<a class="dropdown-item btn-dropdown" href="#">Dưới 2 triệu</a> <a
							class="dropdown-item btn-dropdown " href="#">Từ 2 - 4 triệu</a> <a
							class="dropdown-item btn-dropdown" href="#">Từ 4 - 7 triệu</a> <a
							class="dropdown-item btn-dropdown" href="#">Từ 7 - 13 triệu</a> <a
							class="dropdown-item btn-dropdown" href="#">Từ 13 - 20 triệu</a>
						<a class="dropdown-item btn-dropdown" href="#">Trên 20 triệu</a>
					</div>
					<form class="range-price">
						<div class="display ">
							<span class=" text-center btn-dropdown" id="min">300000</span> <span
								class=" text-center btn-dropdown" id="max">42000000</span>
						</div>
					</form>
					<div class="range-slide">
						<div class="slide">
							<div class="line" id="line" style="left: 0%; right: 0%;"></div>
							<span class="thumb" id="thumbMin" style="left: 0%;"></span> <span
								class="thumb" id="thumbMax" style="left: 100%;"></span>
						</div>
						<input id="rangeMin" type="range" max="42000000" min="300000"
							step="100000" value="0"> <input id="rangeMax"
							type="range" max="42000000" min="300000" step="100000"
							value="42000000">
					</div>
				</div>
			</div>
			<div class="dropdown">
				<button class="btn dropdown-toggle" type="button"
					id="dropdownMenuButton4" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false">Loại Điện Thoại</button>
				<div class="dropdown-menu" aria-labelledby="dropdownMenuButton5">
					<div class="d-flex">
						<a class="dropdown-item btn-dropdown" href="#">Adroid</a> <a
							class="dropdown-item btn-dropdown" href="#">Iphone(IOS)</a>
					</div>
				</div>
			</div>
		</div>
	<!-- 	<div class="grid-dropdown-item brandInfo"></div> -->
	</div>
	<div class="tab-content">
		<div class="tab-panel" id="tab-1">
			<ul class="products-list productInfo">

			</ul>
		</div>
	</div>
	<nav aria-label="Page navigation example">
		<ul class="pagination d-flex justify-content-end">
		</ul>
	</nav>
</section>
