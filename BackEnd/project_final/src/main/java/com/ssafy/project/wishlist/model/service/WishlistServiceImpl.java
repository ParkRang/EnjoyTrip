package com.ssafy.project.wishlist.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.project.wishlist.model.WishlistDto;
import com.ssafy.project.wishlist.model.WishlistImageDto;
import com.ssafy.project.wishlist.model.mapper.WishlistMapper;

@Service
public class WishlistServiceImpl implements WishlistService {

	private WishlistMapper wishlistMapper;
	
	@Autowired
	public WishlistServiceImpl(WishlistMapper wishlistMapper) {
		super();
		this.wishlistMapper = wishlistMapper;
	} 
	
	@Override
	public WishlistDto makeWishlist(WishlistDto wishlistDto) throws Exception {
		return wishlistMapper.makeWishlist(wishlistDto);
	}

	@Override
	public List<WishlistDto> showWishlist() throws Exception {
		return wishlistMapper.showWishlist();
	}

	@Override
	public void addWishlist(WishlistDto wishlistDto) throws Exception {
		wishlistMapper.addWishlist(wishlistDto);
	}

	@Override
	public void removeWishlist(int id) throws Exception {
		wishlistMapper.removeWishlist(id);
	}

}
