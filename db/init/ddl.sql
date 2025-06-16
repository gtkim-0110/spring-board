CREATE TABLE users (
                       "id" integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                       "username" varchar,
                       "role" varchar,
                       "created_at" timestamp DEFAULT now()
);

CREATE TABLE follows (
                         "following_user_id" integer,
                         "followed_user_id" integer,
                         "created_at" timestamp DEFAULT now()
);

CREATE TABLE posts (
                       "id" integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                       "title" varchar,
                       "body" text,
                       "user_id" integer NOT NULL,
                       "status" varchar,
                       "image_url" varchar,
                       "created_at" timestamp DEFAULT now()
);

CREATE TABLE comments (
                          "id" integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                          "comment" text,
                          "post_id" integer NOT NULL,
                          "user_id" integer NOT NULL,
                          "created_at" timestamp DEFAULT now(),
                          "updated_at" timestamp DEFAULT now()
);

COMMENT ON COLUMN "posts"."body" IS 'Content of the post';
COMMENT ON COLUMN "comments"."comment" IS '댓글 내용';

ALTER TABLE posts ADD CONSTRAINT "user_posts" FOREIGN KEY ("user_id") REFERENCES users ("id");

ALTER TABLE follows ADD FOREIGN KEY ("following_user_id") REFERENCES users ("id");
ALTER TABLE follows ADD FOREIGN KEY ("followed_user_id") REFERENCES users ("id");

ALTER TABLE comments ADD CONSTRAINT "user_comments" FOREIGN KEY ("user_id") REFERENCES users ("id");
ALTER TABLE comments ADD CONSTRAINT "post_comments" FOREIGN KEY ("post_id") REFERENCES posts ("id");

-- https://dbdiagram.io/d/684be901ebacb716788059ed