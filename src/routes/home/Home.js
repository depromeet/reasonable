/**
 * React Starter Kit (https://www.reactstarterkit.com/)
 *
 * Copyright © 2014-present Kriasoft, LLC. All rights reserved.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */

import React from 'react';
import PropTypes from 'prop-types';
import withStyles from 'isomorphic-style-loader/lib/withStyles';
import s from './Home.css';
import { getFestivalListByPageApiCall } from '../../api/festivalApi';
import { getUnivDetailApiCall } from '../../api/univApi';
import UnivHome from '../../components/UnivHome';

class Home extends React.Component {
  state = {
    univList: {},
    festivalList: {},
  };
  componentDidMount() {
    getFestivalListByPageApiCall(1).then(
      (festivalList) => {
        this.setState({
          festivalList: festivalList,
        });
        for (const festival of festivalList) {
          getUnivDetailApiCall(festival.university).then(
            (univObject) => {
              const universityDetail = {
                ...univObject,
                start_date: festival.start_date,
                end_date: festival.end_date,
              };
              this.setState({ univList: [...this.state.univList, universityDetail] });
            },
          );
        }
      },
    );
  }
  render() {
    const rows = [];

    // state에 univList가 존재하는지 && 길이가 0 보다 큰지
    if (this.state.univList && this.state.univList.length > 0) {
      this.state.univList.forEach((univ) => {
        rows.push(<UnivHome name={univ.name} logo_url={univ.image_link} start_date={univ.start_date} end_date={univ.end_date} naver_url={univ.naver_link} key={univ.id}/>);
      });
    }
    return (
      <div className={s.root}>
        <div className={s.container}>
          <div className={s.module + ' ' + s.mid}>
            <h2>대학축제를 손쉽게 찾아보세요.</h2>
            <p>
              더 이상 축제 정보 찾아 페이스북 헤매지 마세요.
              <br />
              손쉽게 검색하고, 손쉽게 비교하세요.
            </p>
          </div>
          <h1 className={s.text_univ_list}>대학교 리스트</h1>
          <div className={s.flex_container}>
            {rows}
          </div>
          <button className={s.button_see_more}>see more</button>
        </div>
      </div>
    );
  }
}

export default withStyles(s)(Home);
