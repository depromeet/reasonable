# APIDocs

## University
대학

### 대학 신규등록 [ __POST__ ]
* url
```
http://localhost:8000/university/
```
* request
```
{
    'name': '서울대학교',
    'naver_link': 'https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EC%84%9C%EC%9A%B8%EB%8C%80%ED%95%99%EA%B5%90',
    'image_link': 'http://student.snu.ac.kr/wp-content/uploads/2013/12/snu_portrait.png',
}
```
* response
```
{
  "id": 4,
  "name": "서울대학교",
  "naver_link": "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EC%84%9C%EC%9A%B8%EB%8C%80%ED%95%99%EA%B5%90",
  "image_link": "http://student.snu.ac.kr/wp-content/uploads/2013/12/snu_portrait.png"
}
```



## Artist
가수
### 가수 신규 등록 [ __POST__ ]
* url
```
http://localhost:8000/artist/
```
* request
```
{
    'name': '다이나믹듀오',
    'naver_link': 'https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%EB%93%80%EC%98%A4',
    'image_link': 'http://www.cinecafe.kr/files/attach/images/12850/006/084/41f0c2062993d965c106920c08207a1b.jpg',
}
```
* response
```
{
  "id": 3,
  "name": "다이나믹듀오",
  "naver_link": "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%EB%93%80%EC%98%A4",
  "image_link": "http://www.cinecafe.kr/files/attach/images/12850/006/084/41f0c2062993d965c106920c08207a1b.jpg"
}
```

## Festival
축제

### 축제 목록 조회 [ __GET__ ]
* url

list/[페이지 번호, 맨 처음 시도시 1부터 시작할 것을 권장]
```
http://localhost:8000/festival/list/1
```
* response

대학 축제 목록 반환
```
[
  {
    "id": 1,
    "max_pages": 1,
    "university_id": 1,
    "university_name": "한양대학교",
    "name": "2017축제",
    "start_date": "2017-04-22T07:21:05.750097Z",
    "end_date": "2017-04-22T07:22:50.913085Z",
    "poster_link": "#",
    "university": 1
  },
  {
    "id": 2,
    "max_pages": 1,
    "university_id": 2,
    "university_name": "홍콩과기대",
    "name": "2017홍콩과기대축제",
    "start_date": "2017-04-22T07:27:05.492178Z",
    "end_date": "2017-04-22T07:27:05.492216Z",
    "poster_link": "#",
    "university": 2
  }
]
```

### 축제 상세정보 [ __GET__ ]
* url
```
http://localhost:8000/festival/1
```
* response
```
{
  "id": 1,
  "festival_units": [
    {
      "start_date": "2017-04-22T07:21:49.640336Z",
      "end_date": "2017-04-22T07:21:49.640384Z",
      "artist": 1
    }
  ],
  "name": "2017축제",
  "start_date": "2017-04-22T07:21:05.750097Z",
  "end_date": "2017-04-22T07:22:50.913085Z",
  "poster_link": "#",
  "university": 1
}
```
### 축제 신규등록 [ __POST__ ]
* url
```
http://localhost:8000/festival/
```
* request
```
{
  "name": "2017 한양대축제"
  "start_date": "2017-04-23T13:00"
  "end_date": "2017-04-27T23:00"
  "poster_link": "http://naver.com"
  "university_id": "1"
}
```
* response
```
{
  "id": 4,
  "festival_units": [],
  "name": "2017 한양대축제",
  "start_date": "2017-04-23T09:19:55.840801Z",
  "end_date": "2017-04-23T09:19:55.841148Z",
  "poster_link": "http://naver.com",
  "university": "1"
}
```
## Festival Unit
한 축제 내에서 프로그램 하나를 지칭하는 단위
ex, `다이나믹듀오 - 19:00~21:00`

### Festival Unit 신규등록 [ __POST__ ]
* url
```
http://localhost:8000/festival/unit/
```

* request
```
{
  "artist_id": "3"
  "festival_id": "4"
  "start_date": "2017-03-03T12:30"
  "end_date": "2017-03-04T13:30"
}
```

* response
```
{
  "id": 3,
  "start_date": "2017-04-23T09:45:04.550416Z",
  "end_date": "2017-04-23T09:45:04.550459Z",
  "artist": "3",
  "festival": "4"
}
```