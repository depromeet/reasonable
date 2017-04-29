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

class UnivHome extends React.Component {
  static propTypes = {
    univ_name: PropTypes.string.isRequired,
    univ_logo_url: PropTypes.string.isRequired,
  };

  render() {
    return (
      <div className={s.root}>
        <div className={s.container}>
          <img src={this.props.univ_logo_url} width="225" height="225" alt="logo" />
          <p>{this.props.univ_name}</p>
        </div>
      </div>
    );
  }
}

export default withStyles(s)(UnivHome);
