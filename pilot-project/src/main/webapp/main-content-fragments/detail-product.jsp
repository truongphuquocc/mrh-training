<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<main class="container">
	<section class="row discount-in-day">
		<div class="section-title d-flex">
			<span class="mr-1">Điện Thoại</span> <span style="color: #999;">›</span>
			<div class="detail-title ml-1">Điện thoại
				${productDetail.brand.brandName}</div>
		</div>
		<c:if test="${not empty productDetail }">
			<div class="group-tabs">
				<div class="filter-product">
					<b>Điện thoại ${productDetail.productName}</b> 
				</div>
			</div>
			<div class="content">
				<div class="panel">
					<div class="box-main ">
						<div class="box_left ">
							<a href="#"><img src="/${productDetail.image}" alt=""></a>
						</div>
						<div class="box_right ">
							<div class="box-price d-flex justify-content-between">
								<b>Giá:</b> <b class="price">${productDetail.price}</b>
							</div>
							<div class="box-detail">
								<div class="box-detail-content">
									<div class="box-detail--top">
										<b>Chi Tiết</b>
									</div>
									<div class="box-detail--main">
										<span>${productDetail.description}</span>
									</div>
								</div>
								<div class="box-detail--buy-now">
									<a href="#" class="button-buy-now">Mua Ngay</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:if>
	</section>
</main>