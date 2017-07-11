# baba-cdn-api-examples

com.eg.baba.cdn.examples.Main contains sample code to use CDN APIs


**Example 1**.  Domain basic information

    DescribeCdnDomainBaseDetailRequest req = new DescribeCdnDomainBaseDetailRequest();
    req.setDomainName(domain);
    sendRecv(client, req);

returns

    {
      "requestId": "41ED4FDE-7D50-4EA0-BC74-A880C5023D0B",
      "domainBaseDetailModel": {
        "cname": "subdomain2.acme.com.w.kunlunea.com",
        "cdnType": "web",
        "domainStatus": "online",
        "sourceType": "domain",
        "domainName": "subdomain2.acme.com",
        "gmtModified": "2017-07-10T23:26:39Z",
        "gmtCreated": "2017-04-28T01:39:25Z",
        "sources": [
          "org.subdomain.acme.com"
        ]
      }
    }


**Example 2**.  Domain detail information

    DescribeCdnDomainDetailRequest req = new DescribeCdnDomainDetailRequest();
    req.setDomainName(domain);
    sendRecv(client, req);

returns

    {
      "requestId": "45023346-CFF1-45F0-950A-61C538DCD5BA",
      "getDomainDetailModel": {
        "gmtCreated": "2017-04-28T01:39:25Z",
        "gmtModified": "2017-07-10T23:26:39Z",
        "sourceType": "domain",
        "domainStatus": "online",
        "sourcePort": 80,
        "cdnType": "download",
        "cname": "subdomain2.acme.com.w.kunlunea.com",
        "domainName": "subdomain2.acme.com",
        "scope": "domestic",
        "sources": [
          "org.subdomain.acme.com"
        ]
      }
    }

**Example 3**.  Monitoring data

    DescribeCdnMonitorDataRequest req = new DescribeCdnMonitorDataRequest();
    req.setDomainName(domain);
    req.setStartTime("2017-07-09T15:00:00Z");
    req.setEndTime("2017-07-10T17:00:00Z");
    sendRecv(client, req);

returns

    {
      "requestId": "72F82D44-A1C7-4061-9954-9A585D296FCD",
      "domainName": "subdomain2.acme.com",
      "monitorInterval": 300,
      "startTime": "2017-07-09T15:00:00Z",
      "endTime": "2017-07-10T17:00:00Z",
      "monitorDatas": [
        {
          "timeStamp": "2017-07-09T15:00:00Z",
          "queryPerSecond": "0.71",
          "bytesPerSecond": "1175554",
          "bytesHitRate": "98.90338312297331",
          "requestHitRate": "90.55757316812647",
          "averageObjectSize": "284412.08028169017"
        },
    ...
    ...
        {
          "timeStamp": "2017-07-10T17:00:00Z",
          "queryPerSecond": "0.98",
          "bytesPerSecond": "6402474",
          "bytesHitRate": "96.13916542260546",
          "requestHitRate": "92.50312369845898",
          "averageObjectSize": "1228495.2653061224"
        }
      ]
    }

**Example 4.**  BPS data by domain

    DescribeDomainBpsDataRequest req = new DescribeDomainBpsDataRequest();
    req.setDomainName(domain);
    req.setStartTime("2017-07-11T03:40:00Z");
    req.setEndTime("2017-07-11T04:40:00Z");
    sendRecv(client, req);

returns

    {
      "requestId": "804C836E-16F8-40D3-8B4A-13966E939958",
      "domainName": "subdomain2.acme.com",
      "dataInterval": "300",
      "startTime": "2017-07-10T06:29Z",
      "endTime": "2017-07-11T06:29Z",
      "bpsDataPerInterval": [
        {
          "timeStamp": "2017-07-10T06:30:00Z",
          "value": "29659549",
          "domesticValue": "29659549",
          "overseasValue": "0"
        },
    ...
    ...
        {
          "timeStamp": "2017-07-11T06:20:00Z",
          "value": "91737187",
          "domesticValue": "91737187",
          "overseasValue": "0"
        }
      ],
      "supplyBpsDatas": []
    }

**Example 5**.  Regional statistics by domain

    DescribeDomainRegionDataRequest req = new DescribeDomainRegionDataRequest();
    req.setDomainName(domain);
    req.setStartTime("2017-07-10");
    req.setEndTime("2017-07-10");
    sendRecv(client, req);

returns

    {
      "requestId": "E8F34575-5DF0-4B10-BD56-ADCC6064598F",
      "domainName": "subdomain2.acme.com",
      "dataInterval": "86400",
      "startTime": "2017-07-10",
      "endTime": "2017-07-10",
      "value": [
        {
          "region": "??àý",
          "proportion": "12.599967459731417",
          "regionEname": "Guangdong",
          "avgObjectSize": "2705459.0319096106",
          "avgResponseTime": "9838.540700273155",
          "bps": "5043927.55625",
          "byteHitRate": "87.63012686220574",
          "qps": "0.23304398148148148",
          "reqErrRate": "0.11919543084181773",
          "reqHitRate": "94.03029550533896",
          "avgResponseRate": "274985.8047377389",
          "totalBytes": "54474417607",
          "bytesProportion": "15.270166111341087",
          "totalQuery": "20135"
        },
    ....
    ....
        {
          "region": "÷»?àý",
          "proportion": "6.257743958148209E-4",
          "regionEname": "taiwan",
          "avgObjectSize": "747413.7000000001",
          "avgResponseTime": "154.0",
          "bps": "69.20497222222222",
          "byteHitRate": "99.99999999999999",
          "qps": "1.1574074074074073E-5",
          "reqErrRate": "0.0",
          "reqHitRate": "100.0",
          "avgResponseRate": "4853335.7142857155",
          "totalBytes": "747413",
          "bytesProportion": "2.0951360022104576E-4",
          "totalQuery": "1"
        }
      ]
    }



**Example 6**.  Fetch logs

    DescribeCdnDomainLogsRequest req = new DescribeCdnDomainLogsRequest();
    req.setDomainName(domain);
    req.setStartTime("2017-07-10T15:00:00Z");
    req.setEndTime("2017-07-10T16:00:00Z");		
    sendRecv(client, req);

returns

    {
      "requestId": "83C1351B-574E-450E-A81E-2CAA4C137244",
      "pageNumber": 1,
      "pageSize": 300,
      "totalCount": 2,
      "domainLogModel": {
        "domainName": "subdomain2.acme.com",
        "domainLogDetails": [
          {
            "logName": "subdomain2.acme.com_2017_07_10_2300_2400.gz",
            "logPath": "cdnlog.cn-hangzhou.oss.aliyun-inc.com/subdomain2.acme.com/2017_07_10/subdomain2.acme.com_2017_07_10_2300_2400.gz?OSSAccessKeyId\u003d8ktzZuuF3zUODkn2\u0026Expires\u003d1499927961\u0026Signature\u003dHLrGkSxUH1Z5ks27Zu89TXNQBuU%3D",
            "logSize": 84047,
            "startTime": "2017-07-10T15:00:00Z",
            "endTime": "2017-07-10T16:00:00Z"
          },
          {
            "logName": "subdomain2.acme.com_2017_07_10_2300_2400.gz",
            "logPath": "cdnlog.cn-hangzhou.oss.aliyun-inc.com/subdomain2.acme.com/2017_07_10/subdomain2.acme.com_2017_07_10_2300_2400.gz?OSSAccessKeyId\u003d8ktzZuuF3zUODkn2\u0026Expires\u003d1499927961\u0026Signature\u003dHLrGkSxUH1Z5ks27Zu89TXNQBuU%3D",
            "logSize": 84047,
            "startTime": "2017-07-10T15:00:00Z",
            "endTime": "2017-07-10T16:00:00Z"
          }
        ]
      }
    }