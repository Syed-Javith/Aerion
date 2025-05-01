import {TableHead} from "./TableHead";
import {Constructor, TableConfiguration} from "../../models/table";
import {TableRow} from "./TableRow";

export const Table = ({ conf, data } : { conf: TableConfiguration, data: any[]} ) => {
    conf.filterOpts = conf.filterOpts || {};
    conf.rows = Object.keys(conf.columnMetaData).map(key => conf.columnMetaData[key].key);
    conf.headers = Object.keys(conf.columnMetaData);
    const { headers, parseFunc } = conf;
    headers.forEach((header: string) => { conf.filterOpts[header] = new Set<string>() })
    return (
        <div className={"relative overflow-x-auto min-w-[75vw] mt-5 mx-2"}>
            <table className={"w-full bg-blue-400 text-sm border-black text-left rtl:text-right text-gray-600 dark:text-gray-400"}>
                <TableHead conf={conf} />
                <tbody>
                {
                    data && data.map(( rowData: any, index: number) => {
                        rowData = parseFunc ? parseFunc(rowData) : rowData;
                        return <TableRow key={Number(index)} conf={conf} data={rowData} />;
                    })
                }
                </tbody>
            </table>
        </div>
    );
};
