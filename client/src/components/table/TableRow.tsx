import { TableConfiguration} from "../../models/table";

export const TableRow = ({ conf, data }: { conf: TableConfiguration, data: any }) => {
    const { dataClass, filterOpts, rows, headers } = conf;
    data = data as InstanceType<typeof dataClass>
    return (
        <tr className={"bg-white hover:bg-gray-200"}>
            {
                rows && rows.map((row: string, rowIndex: number) => {
                    let value: any = "-";
                    if(row.indexOf(".") > 0) {
                        const params = row.split(".");
                        let root: any = data;
                        params.forEach(param => {
                            if(root === undefined) {
                                root = "-";
                                return;
                            }
                            root = root[param];
                        });
                        value = root;
                    } else {
                        value = data[row];
                    }
                    if (headers) {
                        filterOpts[headers[rowIndex]].add(value)
                    }
                    return <td className={"px-6 py-4 "}>{value}</td>
                })
            }
        </tr>
    );
};
