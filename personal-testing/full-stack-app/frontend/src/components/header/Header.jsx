import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
// Import Swiper React components
import { Swiper, SwiperSlide } from "swiper/react";

// Import Swiper styles
import "swiper/css";
import "swiper/css/pagination";
import "swiper/css/navigation";

import "./header.css";

// import required modules
import { Autoplay, Navigation, Pagination } from "swiper";

export default function Header() {
  const FEATURED_URL = "http://localhost:8080/api/products/featured";

  const [features, setFeatures] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetch(FEATURED_URL)
      .then((response) => response.json())
      .then((products) => {
        setFeatures(products);
        setLoading(false);
      });
  }, []);

  return (
    <>
      {loading || !features ? (
        <p>Loading...</p>
      ) : (
        <Swiper
          autoplay={{
            delay: 4000,
            disableOnInteraction: false,
          }}
          loop={true}
          navigation={true}
          pagination={{ dynamicBullets: true, clickable: true }}
          modules={[Autoplay, Pagination, Navigation]}
          className="mySwiper swiper"
        >
          {features.map((feature) => (
            <SwiperSlide key={feature.id}>
              <img
                src={"https://picsum.photos/2000/680?random=" + feature.id}
                alt=""
                className="swiper__background"
              />
              <div className="swiper__background--overlay"></div>
              <div className="swiper__content">
                <h2 className="swiper__content__title">{feature.name}</h2>
                <p className="swiper__content__desc">{feature.description}</p>
                <Link
                  to={"/products/" + feature.id}
                  className="swiper__link btn"
                >
                  See more
                </Link>
              </div>
            </SwiperSlide>
          ))}
        </Swiper>
      )}
    </>
  );
}
