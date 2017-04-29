/* eslint-disable */

// api/univApi.js
import request from 'request';
import { SERVER_ADDRESS } from '../constants';

// .../university/list/1
export function getUnivListByPageApiCall(page) {
  return new Promise((resolve, reject) => {
    request.get({
      url: `http://${SERVER_ADDRESS}/university/list/${page}`,
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

// .../university/1
export function getUnivDetailApiCall(univ_id) {
  return new Promise((resolve, reject) => {
    request.get({
      url: `http://${SERVER_ADDRESS}/university/${univ_id}`,
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
