/*
    专门用来存储用户信息
 */

import {defineStore} from "pinia";

/*在定义的 defineSchedule 中存储 */
export const defineSchedule = defineStore(
    "scheduleList",
    {
        state:()=>{
            return {
                itemList:[
                    {
                        sid:1,
                        uid:1,
                        title:'study java',
                        completed:0
                    },
                    {
                        sid:1,
                        uid:1,
                        title:'study java',
                        completed:0
                    },
                    {
                        sid:1,
                        uid:1,
                        title:'study java',
                        completed:0
                    }
                ]
            }
        },
        getters:{

        },
        actions:{

        }
    })