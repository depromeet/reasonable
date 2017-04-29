/* eslint-disable */

// api/festivalApi.js
import request from 'request';
import { SERVER_ADDRESS } from '../constants';

// .../festival/list/1
export function getFestivalListByPageApiCall(page) {
  return new Promise((resolve, reject) => {
    request.get({
      url: `http://${SERVER_ADDRESS}/festival/list/${page}`,
    }, (error, response, body) => {
      if (error) {
        return reject(error);
      }
      // request complete
      if (response.statusCode >= 200 && response.statusCode < 300) {
        let data = body;
        if (typeof (body) === 'string') {
          data = JSON.parse(body);
        }
        return resolve(data);
      }
      return reject(JSON.parse(body));
    });
  });
}