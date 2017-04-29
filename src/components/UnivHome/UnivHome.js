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
import s from './UnivHome.css';
import { UTC_TIME_ZONE } from '../../constants';

class UnivHome extends React.Component {
  static propTypes = {
    name: PropTypes.string.isRequired,
    naver_url: PropTypes.string.isRequired,
    logo_url: PropTypes.string.isRequired,
    start_date: PropTypes.string.isRequired,
    end_date: PropTypes.string.isRequired,

  };

  render() {
    const start_date = new Date(this.props.start_date + UTC_TIME_ZONE);
    const end_date = new Date(this.props.end_date + UTC_TIME_ZONE);
    const festival_period = (start_date.getMonth() + 1) + ('월') + (start_date.getDate()) + ('일 ~ ') + (end_date.getDate()) + ('일');
    return (
      <div className={s.root}>
        <div className={s.container}>
          <a href={this.props.naver_url}>
            <img src={this.props.logo_url} width="224" height="224" alt="logo" />
          </a>
          <p className={s.name}>{this.props.name}</p>
          <p className={s.date}>{festival_period}</p>
        </div>
      </div>
    );
  }
}

export default withStyles(s)(UnivHome);
