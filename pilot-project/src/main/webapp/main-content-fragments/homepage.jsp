<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<section class="row discount-in-day">
	<div class="group-tabs mt-3">
		<div class="box-filter mb-3">
			<div class="dropdown">
				<button class="btn btn-filter dropdown-toggle" type="button"
					id="dropdownMenuButton1" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false">
					<i class="fa-solid fa-filter" style="color: #050505"></i> Bộ lọc
				</button>
				<form action="">
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
						<div class="mb-3">
							<b>Hãng</b>
						</div>
						<div class="grid-dropdown-item brandSearch"></div>
						<div class="dropdown-divider"></div>
						<div class="filter-all">
							<div>
								<div class="mb-3">
									<b>Giá</b>
								</div>
								<div class="grid-dropdown-item">
									<label class="brandtips"> <input type="checkbox"
										name="price" value="0-2000000" /> <span
										class="brandtips_wrap"> <span class="brandtips_tip">Dưới
												2 triệu</span>
									</span>
									</label> <label class="brandtips"> <input type="checkbox"
										name="price" value="2000000-4000000" /> <span
										class="brandtips_wrap"> <span class="brandtips_tip">Từ
												2 - 4 triệu</span>
									</span>
									</label> <label class="brandtips"> <input type="checkbox"
										name="price" value="4000000-7000000" /> <span
										class="brandtips_wrap"> <span class="brandtips_tip">Từ
												4 - 7 triệu</span>
									</span>
									</label> <label class="brandtips"> <input type="checkbox"
										name="price" value="7000000-13000000" /> <span
										class="brandtips_wrap"> <span class="brandtips_tip">Từ
												7 - 13 triệu</span>
									</span>
									</label> <label class="brandtips"> <input type="checkbox"
										name="price" value="13000000-20000000" /> <span
										class="brandtips_wrap"> <span class="brandtips_tip">Từ
												13 - 20 triệu</span>
									</span>
									</label> <label class="brandtips"> <input type="checkbox"
										name="price" value="20000000-9999999999" /> <span
										class="brandtips_wrap"> <span class="brandtips_tip">Trên
												20 triệu</span>
									</span>
									</label>
								</div>
								<p class="range-toggle">
									<a class="" href="#"> <i class="fa-solid fa-sliders"></i> <span>Hoặc
											chọn mức giá phù hợp với bạn</span> <i
										class="down fa-sharp fa-solid fa-caret-up"></i>
									</a>
								</p>
								<div class="range-price d-none">
									<div class="display m-0 mt-3">
										<span class="text-center btn-dropdown min">300000</span> <span
											class="text-center btn-dropdown max">42000000</span>
									</div>
									<div class="range-slide">
										<div class="slide">
											<div class="line" style="left: 0%; right: 0%"></div>
											<span class="thumb thumbMin" style="left: 0%"></span> <span
												class="thumb thumbMax" style="left: 100%"></span>
										</div>
										<input class="rangeMin" type="range" max="42000000"
											min="300000" step="100000" value="0" /> <input
											class="rangeMax" type="range" max="42000000" min="300000"
											step="100000" value="42000000" />
									</div>
								</div>
							</div>
						</div>
						<div
							class="filter-button filter-button--total d-flex mb-3 justify-content-center pt-3">
							<a
								class="btn btn-outline-danger btn-filter-close text-danger mr-3">
								Bỏ chọn</a> <a
								class="btn btn-primary btn-filter-readmore text-white"> Xem
								<b class="total-reloading"></b> kết quả
							</a>
						</div>
					</div>
				</form>
			</div>
			<div class="dropdown">
				<button class="btn btn-filter dropdown-toggle" type="button"
					id="dropdownMenuButton2" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false">Hãng</button>
				<div class="dropdown-menu" aria-labelledby="dropdownMenuButton2">
					<form action="">
						<div class="grid-dropdown-item brandSearch"></div>
						<div
							class="filter-button filter-button--total d-flex mb-3 justify-content-center pt-3">
							<a
								class="btn btn-outline-danger btn-filter-close text-danger mr-3">Bỏ
								chọn</a> <a class="btn btn-primary btn-filter-readmore text-white">
								Xem <b class="total-reloading"></b> kết quả
							</a>
						</div>
					</form>
				</div>
			</div>
			<div class="dropdown">
				<button class="btn btn-filter dropdown-toggle" type="button"
					id="dropdownMenuButton3" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false">Giá</button>
				<div class="dropdown-menu" aria-labelledby="dropdownMenuButton3">
					<form action="">
						<div class="grid-dropdown-item">
							<label class="brandtips"> <input type="checkbox"
								name="price" value="0-2000000" /> <span class="brandtips_wrap">
									<span class="brandtips_tip">Dưới 2 triệu</span>
							</span>
							</label> <label class="brandtips"> <input type="checkbox"
								name="price" value="2000000-4000000" /> <span
								class="brandtips_wrap"> <span class="brandtips_tip">Từ
										2 - 4 triệu</span>
							</span>
							</label> <label class="brandtips"> <input type="checkbox"
								name="price" value="4000000-7000000" /> <span
								class="brandtips_wrap"> <span class="brandtips_tip">Từ
										4 - 7 triệu</span>
							</span>
							</label> <label class="brandtips"> <input type="checkbox"
								name="price" value="7000000-13000000" /> <span
								class="brandtips_wrap"> <span class="brandtips_tip">Từ
										7 - 13 triệu</span>
							</span>
							</label> <label class="brandtips"> <input type="checkbox"
								name="price" value="13000000-20000000" /> <span
								class="brandtips_wrap"> <span class="brandtips_tip">Từ
										13 - 20 triệu</span>
							</span>
							</label> <label class="brandtips"> <input type="checkbox"
								name="price" value="20000000-9999999999" /> <span
								class="brandtips_wrap"> <span class="brandtips_tip">Trên
										20 triệu</span>
							</span>
							</label>
						</div>
						<p class="range-toggle">
							<a class="" href="#"> <i class="fa-solid fa-sliders"></i> <span
								class="">Hoặc chọn mức giá phù hợp với bạn</span> <i
								class="down fa-sharp fa-solid fa-caret-up"></i>
							</a>
						</p>
						<div class="range-price d-none">
							<div class="display m-0 mt-3">
								<span class="text-center btn-dropdown min">300000</span> <span
									class="text-center btn-dropdown max">42000000</span>
							</div>
							<div class="range-slide">
								<div class="slide">
									<div class="line" style="left: 0%; right: 0%"></div>
									<span class="thumb thumbMin" style="left: 0%"></span> <span
										class="thumb thumbMax" style="left: 100%"></span>
								</div>
								<input class="rangeMin" type="range" max="42000000" min="300000"
									step="100000" value="0" /> <input class="rangeMax"
									type="range" max="42000000" min="300000" step="100000"
									value="42000000" />
							</div>
						</div>
						<div
							class="filter-button filter-button--total d-flex mb-3 justify-content-center pt-3">
							<a
								class="btn btn-outline-danger btn-filter-close text-danger mr-3">Bỏ
								chọn</a> <a class="btn btn-primary btn-filter-readmore text-white">
								Xem <b class="total-reloading"></b> kết quả
							</a>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="grid-dropdown-item brandInfo"></div>
		<div class="d-flex justify-content-between mt-3">
			<div class="total-product">
				<b class="countProduct"></b> <span>Điện thoại</span>
			</div>
			<div class="sort-select">
				<select class="form-select" id="sortBy" name="sortBy">
					<option value="0" selected>Nổi bật</option>
					<option value="1">Giá từ cao đến thấp</option>
					<option value="2">Giá từ thấp đến cao</option>
				</select>
			</div>
		</div>
	</div>
	<div class="tab-content">
		<div class="tab-panel" id="tab-1">
			<ul class="products-list productInfo"></ul>
		</div>
	</div>
	<nav aria-label="Page navigation example">
		<ul class="pagination d-flex justify-content-end"></ul>
	</nav>
</section>