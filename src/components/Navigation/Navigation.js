/**
 * React Starter Kit (https://www.reactstarterkit.com/)
 *
 * Copyright © 2014-present Kriasoft, LLC. All rights reserved.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */

import React from 'react';
import cx from 'classnames';
import withStyles from 'isomorphic-style-loader/lib/withStyles';
import s from './Navigation.css';
import Link from '../Link';
import glassUrl from './glass.png';

class Navigation extends React.Component {
  render() {
    return (
      <div className={s.root} role="navigation">
        <div className={s.search_container}>
          <input type="text" className={s.search_bar} />
          <img className={s.search_icon} src={glassUrl} alt="serch field" />
        </div>
      </div>
    );
  }
}

export default withStyles(s)(Navigation);
