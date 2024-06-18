# カフェ情報管理システム

***

## 概要

本システムは、カフェ情報を効率的に管理するためのツールです。  
CRUD処理（CREATE、READ、UPDATE、DELETE）を用いたAPIを中心に構築されており、カフェ情報の登録、更新、取得、削除が可能です。  
直感的なインターフェースにより、簡単にカフェ情報を管理できるためカフェ探しのストレスを軽減します。

## 構成要件

* Java 17
* SpringBoot 3.2.5
* MySQL 8.0.37
* Docker 26.0.0
* JUnit
* Mockito

## 機能一覧

- CREATE処理
    - 新規取得
        - 新しいカフェ情報を登録する
- READ処理
    - 全件取得
        - レコードを全件取得する
    - 絞り込み検索
        - クエリ文字列を使用して特定の場所を記入すると該当するレコードを取得できる
        - IDを検索し該当するレコードを取得できる
    - 例外処理
        - 存在しない場所を記入した際に空の配列がレスポンスされる
        - 存在しないIDをリクエストした場合の例外ハンドリング
- UPDATE処理
    - レコードの更新
        - 指定したIDのカフェ情報を更新する
    - 例外処理
        - 存在しないIDのカフェ情報を更新しようとした場合の例外ハンドリング
- DELETE処理
    - レコードの削除
        - 指定したIDのカフェ情報を削除する
    - 例外処理
        - 存在しないIDのカフェ情報を削除しようとした場合の例外ハンドリング

## DBテーブル

|    **カラム名**     |   **データ型**   | **NotNull** | **キー** | **備考**  |
|:---------------:|:------------:|:-----------:|:------:|:-------:|
|       id        |     int      |  NOT NULL   |  主キー   | ID,自動生成 |
|      name       | VARCHAR(100) |  NOT NULL   |        |   店名    |
|      place      | VARCHAR(40)  |  NOT NULL   |        |  最寄り駅   |
| regular_holiday | VARCHAR(50)  |  NOT NULL   |        |   定休日   |
|  opening_hour   | VARCHAR(50)  |  NOT NULL   |        |  営業時間   |
| number_of_seat  |     int      |  NOT NULL   |        |   席数    |
|   birthplace    | VARCHAR(30)  |  NOT NULL   |        |   発祥地   |

## 実行結果

### CREATE処理

- **POST / cafes** 新しいカフェ情報を登録する **(HTTPステータスコード201)**  
  ![スクリーンショット 2024-05-30 22.38.19.png](https://github.com/Reiji-Shiode/Cafeinfo-Finalassigment/assets/166202078/e8263e24-46b7-4061-9029-9cdd64e6f5f5)

### READ処理

- **GET / cafes** レコードを全件取得する **(HTTPステータスコード200)**  
  ![スクリーンショット 2024-05-27 19.36.53.png](https://github.com/Reiji-Shiode/Cafeinfo-Finalassigment/assets/166202078/329b888f-1f92-4b99-b082-9fe2d1b7db59)

- **GET / cafes?place=◯** クエリ文字列を使用して特定の場所を記入すると該当するレコードを取得できる **(
  HTTPステータスコード200)**  
  ![スクリーンショット 2024-05-11 16.27.29.png](https://github.com/Reiji-Shiode/Cafeinfo-Finalassigment/assets/166202078/5b547012-72c7-4303-8019-bf5a4d547185)

- **GET / cafes/{id}** IDを検索し該当するレコードを取得できる **(HTTPステータスコード200)**  
  ![334075033-45d21055-2a4a-44f3-a420-5e85b28aeeb6.png](https://github.com/Reiji-Shiode/Cafeinfo-Finalassigment/assets/166202078/e67f7e67-4713-4abf-9ce1-79b142b90ec7)

- 存在しない場所を記入した際に空の配列がレスポンスされる **(HTTPステータスコード200)**  
  ![334143858-1fdbc498-538e-40e0-8db4-1eaa6f599b5a-2.png](https://github.com/Reiji-Shiode/Cafeinfo-Finalassigment/assets/166202078/de8ae5de-0df4-43ec-9d5c-4d1529eb68bf)

- 存在しないIDをリクエストした場合の例外ハンドリング **(HTTPステータスコード404)**  
  ![334075318-de49e745-de1c-4525-83a8-a38bd9f610c2.png](https://github.com/Reiji-Shiode/Cafeinfo-Finalassigment/assets/166202078/675889bc-d16c-4b9a-847c-529c927c1e3a)

### UPDATE処理

- **PATCH / cafes/{id}** 指定したIDのカフェ情報を更新する **(HTTPステータスコード200)**  
  ![スクリーンショット 2024-05-31 19.12.04.png](https://github.com/Reiji-Shiode/Cafeinfo-Finalassigment/assets/166202078/c346ca5f-3001-4830-b1ba-9f5da3550fbf)

- 存在しないIDのカフェ情報を更新しようとした場合の例外ハンドリング **(HTTPステータスコード404)**  
  ![スクリーンショット 2024-05-31 19.12.22.png](https://github.com/Reiji-Shiode/Cafeinfo-Finalassigment/assets/166202078/197bfa3e-5f6e-4e34-a3b0-5f0b3b89925b)

### DELETE処理

- **DELETE / cafes/{id}** 指定したIDのカフェ情報を削除する **(HTTPステータスコード200)**  
  ![スクリーンショット 2024-06-01 16.26.59.png](https://github.com/Reiji-Shiode/Cafeinfo-Finalassigment/assets/166202078/48ce1f2f-8005-4426-b7d1-002dabcc6b07)

- 存在しないIDのカフェ情報を削除しようとした場合の例外ハンドリング **(HTTPステータスコード404)**  
  ![スクリーンショット 2024-06-01 16.29.26.png](https://github.com/Reiji-Shiode/Cafeinfo-Finalassigment/assets/166202078/12988687-3dea-4c05-bb50-9afb6e3a6ff0)

（以下課題が進むにつれて随時内容を記載していきます）
