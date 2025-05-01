import {UserAudit} from "../models/Audit";

export const UserAuditRow = ({userAudit } : { userAudit: UserAudit}) => {
    return (
        <tr key={Number(userAudit.id)} className={"bg-white border-b dark:bg-gray-800 dark:border-gray-700 border-gray-200"}>
            <td className={"px-6 py-4"}>{userAudit.user}</td>
            <td className={"px-6 py-4"}>{userAudit.title}</td>
            <td className={"px-6 py-4"}>{userAudit.message}</td>
            <td className={"px-6 py-4"}>{userAudit.ip}</td>
            <td className={"px-6 py-4"}>{new Date(userAudit.timeStamp).toLocaleString()}</td>
        </tr>
    );
};
