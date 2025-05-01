import {FaFilter} from "react-icons/fa";
import {TableConfiguration} from "../../models/table";

export const TableHead = ({ conf } : { conf : TableConfiguration }) => {
    const { headers } = conf;

    const filterData = (header: string) => {
        console.log(conf.filterOpts[header])
    }

    return (
        <thead>
            <tr className={"text-white"}>
                {
                    headers?.map((header: string, index: number) => {
                            return (
                                <th key={Number(index)} className={"px-6 py-3"}>
                                    <span className={"flex gap-3"}>{header}
                                    <FaFilter onClick={() => filterData(header)} className={"float-right mt-0.5"}/>
                                    </span>
                                </th>
                            );
                        }
                    )
                }
            </tr>
        </thead>
    );
};