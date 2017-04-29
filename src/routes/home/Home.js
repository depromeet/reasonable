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

class Home extends React.Component {
  static propTypes = {
    news: PropTypes.arrayOf(PropTypes.shape({
      title: PropTypes.string.isRequired,
      link: PropTypes.string.isRequired,
      content: PropTypes.string,
    })).isRequired,
  };

  render() {
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
        </div>
      </div>
    );
  }
}

export default withStyles(s)(Home);
