import {UserAudit} from "../models/Audit";
import {TableConfiguration} from "../models/table";
import {TablePage} from "../components/pages/TablePage";

export const AuditPage = () => {

    const conf: TableConfiguration = {
        filterOpts: {},
        url: "/api/audit/user",
        headers: ["User", "Title", "Description", "IP Address", "Time"],
        dataClass: UserAudit,
        rows: ["user", "title", "message", "ip", "timeStamp"],
        columnMetaData: {
            "User": {
                key: "user",
                filterKey: "user",
            },
            "Title": {
                key: "title",
                filterKey: "title",
            },
            "Description": {
                key: "message",
                filterKey: "message",
            },
            "IP Address": {
                key: "ip",
                filterKey: "ip",
            },
            "Time": {
                key: "timeStamp",
                filterKey: "timeStamp",
            }
        }
    }

    return (
        <TablePage conf={conf} />
    );
};
