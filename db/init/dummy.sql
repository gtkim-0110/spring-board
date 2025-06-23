-- USERS: 사용자 15명 (이름과 역할)
INSERT INTO users (username, role) VALUES
                                       ('김민수', 'admin'),
                                       ('이영희', 'user'),
                                       ('박지훈', 'user'),
                                       ('최수연', 'user'),
                                       ('정우성', 'moderator'),
                                       ('한지민', 'user'),
                                       ('조세호', 'user'),
                                       ('강호동', 'user'),
                                       ('신동엽', 'user'),
                                       ('유재석', 'user'),
                                       ('김태희', 'admin'),
                                       ('송중기', 'user'),
                                       ('전지현', 'moderator'),
                                       ('수지', 'user'),
                                       ('박보검', 'user');

-- FOLLOWS: 팔로우 관계 약 30건 (일부 예시)
INSERT INTO follows (following_user_id, followed_user_id) VALUES
                                                              (1, 2), (1, 3), (1, 4),
                                                              (2, 5), (2, 6), (2, 7),
                                                              (3, 1), (3, 8), (3, 9),
                                                              (4, 10), (4, 11), (4, 12),
                                                              (5, 1), (5, 6), (5, 13),
                                                              (6, 14), (6, 7), (6, 8),
                                                              (7, 9), (7, 15), (8, 10),
                                                              (9, 11), (9, 2), (10, 3),
                                                              (11, 4), (12, 5), (13, 6),
                                                              (14, 7), (15, 1), (15, 2);

-- POSTS: 각 사용자가 쓴 글
INSERT INTO posts (title, body, user_id, status, image_url) VALUES
                                                                ('첫 번째 글', '안녕하세요! 김민수입니다.', 1, 'published', 'https://example.com/1.jpg'),
                                                                ('오늘의 일기', '날씨가 참 좋네요.', 2, 'published', 'https://example.com/2.jpg'),
                                                                ('맛집 추천', '강남에 있는 맛집 소개할게요.', 3, 'draft', 'https://example.com/3.jpg'),
                                                                ('고양이 이야기', '우리 고양이는 정말 귀여워요.', 4, 'published', 'https://example.com/4.jpg'),
                                                                ('운동 루틴 공유', '아침마다 하는 스트레칭입니다.', 5, 'published', 'https://example.com/5.jpg'),
                                                                ('여행 후기', '제주도에서의 힐링 여행!', 6, 'published', 'https://example.com/6.jpg'),
                                                                ('영화 리뷰', '어제 본 영화 정말 재밌었어요.', 7, 'draft', 'https://example.com/7.jpg'),
                                                                ('하루의 마무리', '오늘도 고생 많았어요.', 8, 'published', 'https://example.com/8.jpg'),
                                                                ('공부 방법 공유', '효율적인 암기법 알려드려요.', 9, 'published', 'https://example.com/9.jpg'),
                                                                ('독서 후기', '최근 읽은 책 추천합니다.', 10, 'published', 'https://example.com/10.jpg'),
                                                                ('새로운 시작', '새 프로젝트를 시작했어요!', 11, 'draft', 'https://example.com/11.jpg'),
                                                                ('요리 이야기', '오늘 저녁은 김치찌개!', 12, 'published', 'https://example.com/12.jpg'),
                                                                ('디자인 팁', '깔끔한 UI를 위한 팁들입니다.', 13, 'published', 'https://example.com/13.jpg'),
                                                                ('산책의 즐거움', '가볍게 걷는 것도 운동이죠.', 14, 'published', 'https://example.com/14.jpg'),
                                                                ('자기계발', '매일 10분씩 투자해요.', 15, 'published', 'https://example.com/15.jpg');

-- COMMENTS: 댓글 (각기 다른 사용자가 포스트에 댓글 단 형태)
INSERT INTO comments (comment, post_id, user_id) VALUES
                                                     ('정말 공감돼요!', 1, 2),
                                                     ('좋은 글 감사합니다.', 2, 3),
                                                     ('저도 가봤어요! 맛있죠?', 3, 4),
                                                     ('고양이 너무 귀엽겠어요~', 4, 5),
                                                     ('이 루틴 따라 해볼게요.', 5, 6),
                                                     ('사진도 함께 올려주세요!', 6, 7),
                                                     ('저도 그 영화 봤어요!', 7, 8),
                                                     ('오늘 하루도 수고했어요.', 8, 9),
                                                     ('암기법 좋네요, 꿀팁!', 9, 10),
                                                     ('책 제목이 뭐에요?', 10, 11),
                                                     ('응원할게요! 화이팅!', 11, 12),
                                                     ('저도 김치찌개 좋아해요.', 12, 13),
                                                     ('UI에 관심 많아요!', 13, 14),
                                                     ('산책 정말 힐링이죠.', 14, 15),
                                                     ('좋은 습관이네요!', 15, 1),
                                                     ('잘 읽었습니다.', 1, 3),
                                                     ('추천 감사해요.', 2, 4),
                                                     ('좋은 하루 보내세요~', 3, 5),
                                                     ('감동이에요.', 4, 6),
                                                     ('응원합니다.', 5, 7);