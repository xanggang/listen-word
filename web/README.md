# 设计规范

## 字号
--text-size-xs: 0.75rem; // 小字
--text-size-sm: 0.875rem; // 辅助文字
--text-size-base: 1rem; // 正文
--text-size-xl: 1.25rem; // 标题
--text-size-2xl: 1.5rem; // 大标题

## 字体颜色
--text-base: var(--oc-gray-7);   // 文本颜色 正文
--text-sub: var(--oc-gray-5);   // 文本的辅助颜色
--text-disabled: var(--oc-gray-6);   // 文本禁用状态

## 灰色背景  基础
--bg-base: var(--oc-gray-0);
// 比基础更深一点 用于背景色的叠加
--bg-base-1: var(--oc-gray-1);

##  描边
// 灰色描边 3
--bdc-base: var(--oc-gray-3);
// 表示禁用状态时
--bdc-disabled: var(--oc-gray-2);

## 反转颜色
--bg-base-inv: var(--oc-gray-9);
// 反转bd
--bd-base-inv: var(--oc-gray-7);
// 反转bg
--text-base-inv: var(--oc-gray-0);

## 系统主要颜色
--primary: #328E6E;
// 更浅一点
--primary-1: #67AE6E;
// 辅助的
--primary-2: #90C67C;
// 反差的
--primary-3: #E1EEBC;


搜索框样式

/* From Uiverse.io by satyamchaudharydev */
/* From uiverse.io by @satyamchaudharydev */
/* this button is inspired by -- whatsapp input */
/* == type to see fully interactive and click the close buttom to remove the text  == */

.form {
--input-bg: #FFf;
/*  background of input */
--padding: 1.5em;
--rotate: 80deg;
/*  rotation degree of input*/
--gap: 2em;
/*  gap of items in input */
--icon-change-color: #15A986;
/*  when rotating changed icon color */
--height: 40px;
/*  height */
width: 200px;
padding-inline-end: 1em;
/*  change this for padding in the end of input */
background: var(--input-bg);
position: relative;
border-radius: 4px;
}

.form label {
display: flex;
align-items: center;
width: 100%;
height: var(--height);
}

.form input {
width: 100%;
padding-inline-start: calc(var(--padding) + var(--gap));
outline: none;
background: none;
border: 0;
}
/* style for both icons -- search,close */
.form svg {
/* display: block; */
color: #111;
transition: 0.3s cubic-bezier(.4,0,.2,1);
position: absolute;
height: 15px;
}
/* search icon */
.icon {
position: absolute;
left: var(--padding);
transition: 0.3s cubic-bezier(.4,0,.2,1);
display: flex;
justify-content: center;
align-items: center;
}
/* arrow-icon*/
.swap-off {
transform: rotate(-80deg);
opacity: 0;
visibility: hidden;
}
/* close button */
.close-btn {
/* removing default bg of button */
background: none;
border: none;
right: calc(var(--padding) - var(--gap));
box-sizing: border-box;
display: flex;
align-items: center;
justify-content: center;
color: #111;
padding: 0.1em;
width: 20px;
height: 20px;
border-radius: 50%;
transition: 0.3s;
opacity: 0;
transform: scale(0);
visibility: hidden;
}

.form input:focus ~ .icon {
transform: rotate(var(--rotate)) scale(1.3);
}

.form input:focus ~ .icon .swap-off {
opacity: 1;
transform: rotate(-80deg);
visibility: visible;
color: var(--icon-change-color);
}

.form input:focus ~ .icon .swap-on {
opacity: 0;
visibility: visible;
}

.form input:valid ~ .icon {
transform: scale(1.3) rotate(var(--rotate))
}

.form input:valid ~ .icon .swap-off {
opacity: 1;
visibility: visible;
color: var(--icon-change-color);
}

.form input:valid ~ .icon .swap-on {
opacity: 0;
visibility: visible;
}

.form input:valid ~ .close-btn {
opacity: 1;
visibility: visible;
transform: scale(1);
transition: 0s;
}
