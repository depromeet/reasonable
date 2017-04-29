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
import { StickyContainer, Sticky } from 'react-sticky';
import s from './Layout.css';
import Header from '../Header';
import Feedback from '../Feedback';
import Footer from '../Footer';

class Layout extends React.Component {
  static propTypes = {
    children: PropTypes.node.isRequired,
  };

  render() {
    const customStyleObject = {
      zIndex: 998,
    };
    return (
      <StickyContainer>
        <Sticky stickyStyle={customStyleObject}>
          <Header />
        </Sticky>
        {this.props.children}
      </StickyContainer>
    );
  }
}

export default withStyles(s)(Layout);
