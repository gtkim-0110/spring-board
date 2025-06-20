CREATE TYPE menu_role AS ENUM ('user', 'admin');

CREATE TABLE menu (
                      id SERIAL PRIMARY KEY,
                      pid INTEGER REFERENCES menu(id) ON DELETE CASCADE, -- 상위 메뉴
                      name VARCHAR(100) NOT NULL,          -- 메뉴 이름
                      src VARCHAR(255) NOT NULL,           -- 링크 또는 컴포넌트 경로
                      order_no INTEGER DEFAULT 0,          -- 정렬 순서
                      icon VARCHAR(50),                    -- 아이콘 (선택)
                      is_active BOOLEAN DEFAULT true,      -- 표시 여부
                      depth INTEGER,                       -- 메뉴 깊이 (계층 구조용)
                      component VARCHAR(50),
                      menu_role menu_role NOT NULL DEFAULT 'user',
                      created_at TIMESTAMP DEFAULT NOW(),
                      updated_at TIMESTAMP DEFAULT NOW()
);

select * from menu;


INSERT INTO menu (pid, name, src, depth, component) values (null, '메인','/main',0, 'Main');
INSERT INTO menu (pid, name, src, depth, component) values (null, '대쉬보드','/dashboard',0, 'Dashboard');
INSERT INTO menu (pid, name, src, depth, component) values (null, '관리자','/admin',0, 'Admin');
INSERT INTO menu (pid, name, src, depth, component) values (3, '게시판','/admin/board',1, 'Admin');

