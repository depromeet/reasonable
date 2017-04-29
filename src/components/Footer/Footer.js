/**
 * React Starter Kit (https://www.reactstarterkit.com/)
 *
 * Copyright © 2014-present Kriasoft, LLC. All rights reserved.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */

import React from 'react';
import withStyles from 'isomorphic-style-loader/lib/withStyles';
import s from './Footer.css';
import Link from '../Link';
import facebookUrl from './facebook.png';
import instagramUrl from './instagram.png';
import twitterUrl from './twitter.png';
class Footer extends React.Component {
  render() {
    return (
      <div className={s.root}>
        <div className={s.container}>
          <div className={s.icons}>
            <img src={facebookUrl} className={s.right_margin} width="30" height="30" alt="facebook" />
            <img src={instagramUrl} className={s.right_margin} width="30" height="30" alt="instagram" />
            <img src={twitterUrl} width="30" height="30" alt="twitter" />
          </div>
          <p className={s.text}>Copyright © 2017 Reasonable of Depromeet</p>
        </div>
      </div>
    );
  }
}

export default withStyles(s)(Footer);
