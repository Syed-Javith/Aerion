
export interface Audit {
    id: Number;
    title: string;
    message: string;
    timeStamp: Number;
}

export class UserAudit implements Audit {
    user: string;
    ip: string;
    id: Number;
    message: string;
    timeStamp: number;
    title: string;

    constructor(id: Number, title: string, message: string, timeStamp: number, user: string, ip: string) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.timeStamp = timeStamp;
        this.user = user;
        this.ip = ip;
    }
}

export class ApiAudit {
    api: string;
    id: Number;
    message: string;
    timeStamp: number;
    title: string;

    constructor(id: Number, title: string, message: string, timeStamp: number, api: string) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.timeStamp = timeStamp;
        this.api = api
    }
}

